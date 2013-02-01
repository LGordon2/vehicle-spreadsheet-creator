package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import classes.Constants;

import com.ibm.as400.access.AS400JDBCDriver;

public class DatabaseConnection {
    private String connectionState;
    private Connection connection;
    public String url;
    private ArrayList<OnStateChangedListener> onStateChangedListeners;

	// Private constructor prevents instantiation from other classes
    private DatabaseConnection() { 
    	onStateChangedListeners = new ArrayList<OnStateChangedListener>();
    	connectTo(Constants.DEFAULT_DB_URL);
    }
    
    public void addOnStateChangeListener(OnStateChangedListener o){
    	onStateChangedListeners.add(o);
    }
    
    private void stateChanged(){
    	for(OnStateChangedListener o : onStateChangedListeners){
    		o.onDBStateChange();
    	}
    }
    
    public boolean isConnected(){
    	return this.connectionState.equals(Constants.DB_CONNECTED)?true:false;
    }
    public void connectTo(final String url){
    	this.connectionState = Constants.DB_NOT_CONNECTED;
    	new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					DatabaseConnection.this.connection = setUpConnection(url);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					DatabaseConnection.this.connectionState = Constants.DB_CONNECTION_ERROR;
					e.printStackTrace();
				}
			}
    		
    	}).start();
    }
	private Connection setUpConnection(String url) throws SQLException {
		connectionState = Constants.DB_CONNECTING;
		stateChanged();
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "lgordon");
		connectionProps.put("password", "orasi101");
		DriverManager.registerDriver(new AS400JDBCDriver());
		conn = DriverManager.getConnection(url, connectionProps);
		System.out.println("Connected to database");
		connectionState = Constants.DB_CONNECTED;
		stateChanged();
		this.url = url;
		return conn;
	}
	
	public Connection getConnection(){
		return this.connection;
	}

    /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class DatabaseConnectionHolder { 
            public static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
            return DatabaseConnectionHolder.INSTANCE;
    }
}
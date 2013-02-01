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
	public Properties connectionProps;

	// Private constructor prevents instantiation from other classes
    private DatabaseConnection() { 
    	onStateChangedListeners = new ArrayList<OnStateChangedListener>();
		this.connectionProps = new Properties();
		this.connectionProps.put("user", Constants.DEFAULT_USERNAME);
		this.connectionProps.put("password", Constants.DEFAULT_PASSWORD);
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
					setUpConnection(url);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					DatabaseConnection.this.connectionState = Constants.DB_CONNECTION_ERROR;
					e.printStackTrace();
				}
			}
    		
    	}).start();
    }
	private void setUpConnection(String url) throws SQLException {
		connectionState = Constants.DB_CONNECTING;
		stateChanged();
		DriverManager.registerDriver(new AS400JDBCDriver());
		this.connection = DriverManager.getConnection(url, this.connectionProps);
		System.out.println("Connected to database ["+url+"]");
		connectionState = Constants.DB_CONNECTED;
		stateChanged();
		this.url = url;
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
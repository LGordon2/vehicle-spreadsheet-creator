package ui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import classes.SheetPanel;
import database.DatabaseConnection;


public class MainApp implements ItemListener{

	private JFrame frmVehicleSpreadsheetCreator;
	private ArrayList<SheetPanel> sheetPanels;
	private JTabbedPane tabbedPane;
	private RunPanel runPanel;
	private RegisterPanel registerPanel;
	private SellPanel sellPanel;
	private static JProgressBar progressBar = new JProgressBar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frmVehicleSpreadsheetCreator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DatabaseConnection.getInstance();
		sheetPanels = new ArrayList<SheetPanel>();
		frmVehicleSpreadsheetCreator = new JFrame();
		frmVehicleSpreadsheetCreator.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/images/manheim.gif")));
		frmVehicleSpreadsheetCreator.setTitle("Vehicle Spreadsheet Creator");
		frmVehicleSpreadsheetCreator.setBounds(100, 100, 640, 480);
		frmVehicleSpreadsheetCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmVehicleSpreadsheetCreator.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("Create");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						try {
							createNewExcel();
						} catch (BiffException | WriteException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}).start();
			}
		});
		mnFile.add(mntmNew);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmQuit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		frmVehicleSpreadsheetCreator.getContentPane().setLayout(gridBagLayout);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frmVehicleSpreadsheetCreator.getContentPane().add(tabbedPane, gbc_tabbedPane);

		runPanel = new RunPanel();
		runPanel.addTabChangerListener(this);
		sheetPanels.add((SheetPanel) runPanel);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) runPanel.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 1.0};
		tabbedPane.addTab("Run", null, runPanel, null);
		
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		frmVehicleSpreadsheetCreator.getContentPane().add(progressBar, gbc_progressBar);

		registerPanel = new RegisterPanel();

		sellPanel = new SellPanel();
		((SheetPanel) sellPanel).addDependentSheet((SheetPanel) registerPanel);

	}

	protected synchronized void createNewExcel() throws BiffException, IOException, WriteException {
		Map<String, String> env = System.getenv();
		File folder = new File(env.get("USERPROFILE")+File.separator+"VehicleAutomation");
		folder.mkdir();
		WritableWorkbook workbook = Workbook.createWorkbook(new File(env.get("USERPROFILE")+File.separator+"VehicleAutomation"+File.separator+"MasterDriver.xls"));
		MainApp.setProgress(10, "Creating file.");
		for(int i=0;i<sheetPanels.size();i++){
			if(runPanel.isEnabledSheetPanel(sheetPanels.get(i).getDescription()) || 
					sheetPanels.get(i).getDescription().equals(runPanel.getDescription())){
				MainApp.setProgress(10+(80/sheetPanels.size())*(i+1), "Creating sheet: "+sheetPanels.get(i).getDescription());
				sheetPanels.get(i).createSheet(workbook, i);
				sheetPanels.get(i).writeSheet();
			}
		}
		workbook.write();
		workbook.close();
		MainApp.setProgress(100, "Finished writing spreadsheet.");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		SheetPanel tabPanel = null;
		if(((JCheckBox) e.getSource()).getText().equals("Register"))
			tabPanel = registerPanel;
		else if(((JCheckBox) e.getSource()).getText().equals("Sell"))
			tabPanel = sellPanel;

		if(((AbstractButton) e.getSource()).isSelected()){
			sheetPanels.add(tabPanel);
			tabbedPane.addTab(((JCheckBox) e.getSource()).getText(), null, tabPanel, null);
		}else{
			sheetPanels.remove((SheetPanel) tabPanel);
			tabbedPane.remove(tabPanel);
		}
	}
	
	public static synchronized void setProgress(int value, String message){
		progressBar.setValue(value);
		if(message!=null){
			progressBar.setString(message);
			progressBar.setStringPainted(true);
		}else
			progressBar.setStringPainted(false);
	}
}

package ui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class MainApp{

	private JFrame frmVehicleSpreadsheetCreator;
	private ArrayList<SheetPanel> sheetPanels;
	private JTabbedPane tabbedPane;
	private RunPanel runPanel;

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
		sheetPanels = new ArrayList<SheetPanel>();
		frmVehicleSpreadsheetCreator = new JFrame();
		frmVehicleSpreadsheetCreator.setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/images/manheim.gif")));
		frmVehicleSpreadsheetCreator.setTitle("Vehicle Spreadsheet Creator");
		frmVehicleSpreadsheetCreator.setBounds(100, 100, 450, 300);
		frmVehicleSpreadsheetCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmVehicleSpreadsheetCreator.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("Create");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					createNewExcel();
				}catch (BiffException e){	
				} catch(IOException e){
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frmVehicleSpreadsheetCreator.getContentPane().setLayout(gridBagLayout);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frmVehicleSpreadsheetCreator.getContentPane().add(tabbedPane, gbc_tabbedPane);

		runPanel = new RunPanel();
		sheetPanels.add((SheetPanel) runPanel);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) runPanel.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 1.0};
		tabbedPane.addTab("Run", null, runPanel, null);

		JPanel registerPanel = new RegisterPanel();
		sheetPanels.add((SheetPanel) registerPanel);
		tabbedPane.addTab("Register", null, registerPanel, null);
		
		JPanel sellPanel = new SellPanel();
		sheetPanels.add((SheetPanel) sellPanel);
		tabbedPane.addTab("Sell", null, sellPanel, null);

	}

	protected void createNewExcel() throws BiffException, IOException, WriteException {
		// TODO Auto-generated method stub
		Map<String, String> env = System.getenv();
		File folder = new File(env.get("USERPROFILE")+File.separator+"VehicleAutomation");
		folder.mkdir();
		WritableWorkbook workbook = Workbook.createWorkbook(new File(env.get("USERPROFILE")+File.separator+"VehicleAutomation"+File.separator+"MasterDriver.xls"));

		for(int i=0;i<sheetPanels.size();i++){
			if(runPanel.isEnabledSheetPanel(sheetPanels.get(i).getDescription()) || 
					sheetPanels.get(i).getDescription().equals(runPanel.getDescription())){
				sheetPanels.get(i).createSheet(workbook, i);
				sheetPanels.get(i).writeSheet();
			}
		}

		workbook.write();
		workbook.close();
	}
}

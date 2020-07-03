package com.property;

import java.awt.EventQueue;

import com.property.utils.FileDb;
import com.property.view.LoginView;

public class App {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FileDb fm = new FileDb();
					fm.loadBranchFromFile();
					fm.loadHouseFromFile();
					fm.loadFlatFromFile();
					fm.loadIdFromFile();
					
					LoginView view = new LoginView();
					view.setResizable(false);
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

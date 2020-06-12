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
					fm.loadBranch();
					fm.loadHouse();
					fm.loadFlat();
					fm.loadId();
					
					LoginView frame = new LoginView();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

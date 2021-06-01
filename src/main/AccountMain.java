package main;

import ui.MainUI;

public class AccountMain {
	public static void main(String[] args) {
		MainUI ui = new MainUI();
		try {
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

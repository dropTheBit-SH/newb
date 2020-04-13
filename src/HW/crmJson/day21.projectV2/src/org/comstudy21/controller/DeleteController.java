package org.comstudy21.controller;

public class DeleteController implements Controller {

	public DeleteController() {
	}

	@Override
	public void service() {
		dao.delete(listView.getRow());
	}

}

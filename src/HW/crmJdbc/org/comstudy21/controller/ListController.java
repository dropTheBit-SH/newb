package org.comstudy21.controller;

import java.util.Vector;

import org.comstudy21.model.Member;
import org.comstudy21.resource.R;

public class ListController implements Controller, R {
	@Override
	public void service() {
		Vector<Vector> all = dao.selectAll();
		dm.setDataVector(all, columnIdentifiers);
	}
}

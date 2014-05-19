package cn.imcore.manage;

import java.util.Vector;

import cn.imcore.entity.Person;

public class PersonManage {


	//添加人员
	public void addPerson(Person p) {
		Vector v = new Vector();
		v.add(p.getIds());
		v.add(p.getName());
		v.add(p.getAge());
		v.add(p.getSex());
		JTableModel.rowdatas.add(v);
	}
	
	//修改人员
	public void updPerson(Person p) {
		for(int i=0; i<JTableModel.rowdatas.size(); i++) {
			Vector v1 = JTableModel.rowdatas.get(i);
			int id = (Integer) v1.get(0);
			if(p.getIds() == id) {
//				v1.set(0, p.getIds());
				v1.set(1, p.getName());
				v1.set(2, p.getAge());
				v1.set(3, p.getSex());
			}
		}
	}
	
	//删除人员
	public void delPerson(int ids) {
		for(int i=0; i<JTableModel.rowdatas.size(); i++) {
			Vector v1 = JTableModel.rowdatas.get(i);
			int id = (Integer) v1.get(0);
			if(ids == id) {
				JTableModel.rowdatas.remove(i);
			}
		}
	}
	//取人员信息
	public Person getPerson(int ids) {
		Person p = new Person();
		for(int i=0; i<JTableModel.rowdatas.size(); i++) {
			Vector v1 = JTableModel.rowdatas.get(i);
			int id = (Integer) v1.get(0);
			if(ids == id) {
				p.setIds(id);
				p.setName((String)v1.get(1));
				p.setAge((Integer)v1.get(2));
				p.setSex((String)v1.get(3));
			}
		}
		
		return p;
	}

}

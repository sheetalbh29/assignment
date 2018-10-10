package p1;

import java.util.HashMap;

public class Database {
	HashMap<Integer,Project> hmap=new HashMap<Integer,Project>();

	public Database() {
		hmap.put(1,new Project(1,"Science","A-type"));
		hmap.put(2,new Project(2,"Maths","B-type"));
	}

	public Project getProjectDetails(int id)
	{
		return hmap.get(id);
	}
}

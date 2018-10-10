package p1;

public class Project {
	int projectId;
	String name;
	String type;
	public Project(int projectId, String name, String type) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.type = type;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", type=" + type + "]";
	} 
}

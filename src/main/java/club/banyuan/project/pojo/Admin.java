package club.banyuan.project.pojo;

public class Admin {
    private String admName;
    private String admPassword;

    public Admin(String admName, String admPassword) {
        this.admName = admName;
        this.admPassword = admPassword;
    }

    public Admin() {
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admName='" + admName + '\'' +
                ", admPassword='" + admPassword + '\'' +
                '}';
    }
}

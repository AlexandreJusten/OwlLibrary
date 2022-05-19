package Conection.DAO;

import staticJavaApl.StaticMain;

import java.io.IOException;

public class UserBanco {
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void InicializarUserDatabaseTxt() throws IOException {
        StaticMain staticMain = new StaticMain();

       UserBanco a = staticMain.LerUser();
        setUser(a.getUser());
        setPassword(a.getPassword());

    }


}

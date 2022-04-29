package staticJavaApl;

import Conection.DAO.UserBanco;

import java.io.*;

public class StaticMain {

	public void EscreverUser(String user,String password){


		File dir = new File("./");
		File arq = new File(dir, "UserDataBase.txt");

		try {

			arq.createNewFile();

			FileWriter fileWriter = new FileWriter(arq, false);

			PrintWriter printWriter = new PrintWriter(fileWriter);

				printWriter.println(user);
				printWriter.println(password);

			printWriter.flush();

			printWriter.close();

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public UserBanco LerUser() throws IOException {
		File dir = new File("./");
		File arq = new File(dir, "UserDataBase.txt");
		arq.createNewFile();


		try {

			FileReader fileReader = new FileReader(arq);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String linha = "";
			int n=0;
			UserBanco userBanco = new UserBanco();
			while ((linha = bufferedReader.readLine()) != null) {
				if (n==0){
				userBanco.setUser(linha);}
				else {
				userBanco.setPassword(linha);}
				n++;
			}
			return userBanco;
		}
		catch (Exception e) {
			System.out.println("Erro na function ler do staticJavaApl!!"+e);
		}
		return null;
	}

}

package primeministers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 */
public class Reader extends IO{
	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド。
	 */
	private File filename;
	/**
	 * リーダのコンストラクタ。
	 */
	Reader(){
		super();
		this.filename=new File("./PrimeMinisters.csv");
	}
	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。
	 * @return
	 */
	public static File filenameOfCSV(){
		File aFile = new File("./PrimeMinisters.csv");
		return aFile;
	}
	/**
	 * ダウンロードしたCSVファイルを応答する。
	 * @return this.filename
	 */
	public File filename(){
		return this.filename;
	}
	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 */
	public Table table(){
		Table aTable=new Table();
		Attributes instanceOfAttributes=new Attributes("input");
		FileReader aFileReader;
		try {
			aFileReader = new FileReader(this.filename());

			BufferedReader aCSVReader = new BufferedReader(aFileReader);
			String aString;
			while((aString=aCSVReader.readLine())!=null){
				ArrayList<String> valueCollection=splitString(aString,",");
				Tuple aTuple = new Tuple(instanceOfAttributes,valueCollection);
				aTable.add(aTuple);
			}
			aFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aTable;
	}

}


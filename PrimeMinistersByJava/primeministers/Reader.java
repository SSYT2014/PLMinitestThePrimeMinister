package primeministers;

import java.io.File;
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
		this.filename=new File(super.directoryOfPages(),"PrimeMinisters.csv");
	}
	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。
	 * @return
	 */
	public static File filenameOfCSV(){
		File aFile = new File(IO.directoryOfPages(),"PrimeMinisters.csv");
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
		boolean firstLine = true;
		ArrayList<String> aCollection = super.readTextFromFile(this.filename);
		Tuple aTuple;
		for(String Line : aCollection){
			ArrayList<String> splitString = super.splitString(Line, ",");
			if(firstLine){
				aTable.attributes(instanceOfAttributes);
				aTable.attributes().names(splitString);
				firstLine=false;
			}else{
				aTuple = new Tuple(aTable.attributes(),splitString);
				aTable.add(aTuple);
			}
		}
		return aTable;
	}
}


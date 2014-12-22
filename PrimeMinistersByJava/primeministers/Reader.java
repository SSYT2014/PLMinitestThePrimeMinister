package primeministers;

import java.io.File;
import java.util.ArrayList;

/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 * 良好(2014年12月22日)
 */
public class Reader extends IO{
	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド。
	 * 良好(2014年12月22日)
	 */
	private File filename;
	/**
	 * リーダのコンストラクタ。
	 * 良好(2014年12月22日)
	 */
	Reader(){
		super();
		this.filename=new File(super.directoryOfPages(),"PrimeMinisters.csv");
	}
	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。
	 * 良好(2014年12月22日)
	 * @return aFile
	 */
	public static File filenameOfCSV(){
		File aFile = new File(IO.directoryOfPages(),"PrimeMinisters.csv");
		return aFile;
	}
	/**
	 * ダウンロードしたCSVファイルを応答する。
	 * 良好(2014年12月22日)
	 * @return this.filename
	 */
	public File filename(){
		return this.filename;
	}
	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 * 良好(2014年12月22日)
	 * @return aTable
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


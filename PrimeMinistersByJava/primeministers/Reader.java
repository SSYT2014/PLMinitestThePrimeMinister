package primeministers;

import java.io.File;
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
		this.filename=new File("");
	}
	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。
	 * @return
	 */
	public static File filenameOfCSV(){
		File aFile = new File("");
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
		return aTable;
	}
	
}


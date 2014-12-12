package primeministers;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

/**
 * ライタ：総理大臣の情報のテーブルをHTMLページとして書き出す。
 */
public class Writer extends IO{
	/**
	 * ライタのコンストラクタ。
	 */
	public Writer(){
		
	}
	/**
	 * 属性リストを応答する
	 * @return
	 */
	public Attributes attributes(){
		return null;
	}
	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 * @return
	 */
	public static File filenameOfHTML(){
		 return null;
	}
	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 * @param aTable
	 * @return
	 */
	public Table table(Table aTable){
		Table resultTable = new Table();
		return resultTable;
	}
	/**
	 * タプル群を応答する
	 * @return
	 */
	public ArrayList<Tuple> tuples(){
		ArrayList<Tuple> tuples = new ArrayList<Tuple>();
		return tuples;
	}
	/**
	 * 属性リストを書き出す。
	 * @param outputWriter
	 */
	public void writeAttributesOn(BufferedWriter outputWriter){
		
	}
	/**
	 * フッタを書き出す。
	 * @param outputWriter
	 */
	public void writeFooterOn(BufferedWriter outputWriter){
		
	}
	/**
	 * ヘッダを書き出す。
	 * @param outputWriter
	 */
	public void writeHeaderOn(BufferedWriter outputWriter){
		
	}
	/**
	 * ボディを書き出す。
	 * @param outputWriter
	 */
	public void writeTableBodyOn(BufferedWriter outputWriter){
		
	}
	/**
	 * タプル群を書き出す。
	 * @param outputWriter
	 */
	public void writeTuplesOn(BufferedWriter outputWriter){
		
	}
}

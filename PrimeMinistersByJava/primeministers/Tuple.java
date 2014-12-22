package primeministers;

import java.util.ArrayList;

/**
 * タプル：総理大臣の情報テーブルの中の各々のレコード。
 * 良好(2014年12月22日)
 */
public class Tuple extends Object
{
	private Attributes attributes;
	private ArrayList<String> values;
	/**
	 * 属性リストと値リストからタプルを作るコンストラクタ。
	 * 良好(2014年12月22日)
	 * @param instanceOfAttributes
	 * @param balueCollection
	 */
	public Tuple(Attributes instanceOfAttributes,ArrayList<String> valueCollection){
		this.attributes=instanceOfAttributes;
		this.values=valueCollection;
	}
	/**
	 * 属性リストを応答する。
	 * 良好(2014年12月22日)
	 * @return
	 */
	public Attributes attributes(){
		return this.attributes;
	}
	/**
	 * 自分自身を文字列にして、それを応答する。
	 * 良好(2014年12月22日)
	 */
	public String toString(){
		return super.toString();
	}
	/**
	 * 値リストを応答する。
	 * 良好(2014年12月22日)
	 * @return
	 */
	public ArrayList<String> values(){
		return this.values;
	}
	
}

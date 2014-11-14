package primeministers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 表：総理大臣の情報テーブル。
 */
public class Table extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;
	/**
	 * タプル郡を記憶するフィールド。
	 */
	private ArrayList<Tuple> tuples;
	/**
	 * 画像群を記憶するフィールド。
	 */
	private ArrayList<BufferedImage> images;
	/**
	 * サムネイル画像群を記憶するフィールド
	 */
	private ArrayList<BufferedImage> thumbnails;
	/**
	 * テーブルのコンストラクタ。
	 */
	Table(){
		
	}
	/**
	 * 属性リストを応答する。
	 * @param aTuple
	 */
	public void add(Tuple aTuple){
		
	}
	/**
	 * 属性リストを応答する。
	 * @return
	 */
	public Attributes attributes(){
		
	}
	/**
	 * 属性リストを設定する。
	 * @param instanceOfAttributes
	 */
	public void attributes(Attributes instanceOfAttributes){
		
	}
	/**
	 * 画像群を応答する。
	 * @return
	 */
	public ArrayList<BufferedImage> images(){
		
	}
	/**
	 * 画像またはサムネイル画像の文字列を受け取って当該画像を応答する。
	 * @param aString
	 * @return
	 */
	private BufferedImage picture(String aString){
		
	}
	/**
	 * サムネイル画像群を応答する。
	 * @return
	 */
	public ArrayList<BufferedImage> thumbnails(){
		
	}
	/**
	 * 自分自身を文字列にして、それを応答する。
	 * @Override
	 */
	public String toString(){
		
	}
	/**
	 * タプル群を応答する。
	 * @return
	 */
	public ArrayList<Tuple> tuples(){
		
	}
}

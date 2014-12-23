#! /usr/bin/env python
# -*- coding: utf-8 -*-


__author__ = "Tokuume Shinya<g1244785@cc.kyoto-su.ac.jp>"
__status__ = "production"
__date__ = "22 December 2014"

class Attributes(object):
	"""属性リスト：総理大臣の情報テーブルを入出力する際の属性情報を記憶。"""

	def __init__(self, kind_string):
		"""入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。"""
		if kind_string == "output":
			self._name = ["人目","代","氏名","ふりがな","在位期間","在位日数","出身校","政党","出身地","画像"]
			self._keys = ["id","no","name","ruby",'util','period',"school","party","country","img","thum","link"]
		
		elif kind_string == "input":
			self._name = ["人目","代","氏名","ふりがな","在位期間","出身校","政党","出身地","画像","縮小画像"]
			self._keys = ["id","no","name","ruby","util","school","party","country","img","thum"]
		
		else:
			print "Beyond expected input!!"

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		a_str = str(self.__class__.__name__)+'\n'
		for (value,key) in zip(self._name,self._keys):
			a_str += 'name:'+str(value)+' id:'
			a_str += str(key)+'\n'
		return a_str

	def keys(self):
		"""キー群を応答する。"""
		return self._keys

	def names(self):
		"""名前群を応答する。"""
		return self._name

	def set_names(self, names):
		"""名前群を設定する。"""
		self._name.append(names)
		return

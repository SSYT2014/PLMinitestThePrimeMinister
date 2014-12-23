#! /usr/bin/env python
# -*- coding: utf-8 -*-


__author__ = "Tokuume Shinya<g1244785@cc.kyoto-su.ac.jp>"
__status__ = "production"
__date__ = "22 December 2014"

class Tuple(object):
	"""タプル：総理大臣の情報テーブルの中の各々のレコード。"""

	def __init__(self, attributes, values):
		"""属性リストと値リストからタプルを作るコンストラクタ。"""
		self.attributes = attributes
		self.values = values
		

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		a_str = str(self.__class__.__name__)+'\n'
		for (attribute,value) in zip(self.attributes,self.values):
			a_str += str(attribute)+':'
			a_str += str(value)+'\n'
		a_str += "\n"
		return a_str

	def attributes(self):
		"""属性リストを応答する。"""
		return self.attributes

	def values(self):
		"""値リストを応答する。"""
		return self.values

	def set_attributes(self,attributes):
		"""属性リストを設定する """
		self.attributes = attributes
		return

	def set_values(self,values):
		"""値リストを設定する。"""
		self.values = values
		return 

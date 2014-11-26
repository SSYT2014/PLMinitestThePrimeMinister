#! /usr/bin/env python
# -*- coding: utf-8 -*-

import attributes

class Table(object):
	"""表：総理大臣の情報テーブル。"""

	def __init__(self,kind_string):
		"""テーブルのコンストラクタ。"""
		self.kind_string = kind_string
		self.attribute = attributes.Attributes(kind_string)
		self.images_names = []
		self.thumbnail_names = []
		self.tup = []
	

	def __str__(self):
		"""自分自身を文字列にして、それを応答する。"""
		a_str = str(self.__class__.__name__)+'文字列で返答\n'
		a_str += self.attribute.__str__()
		for tups in self.tup:
			a_str += tups.__str__()
		
		return a_str

	def add(self, tuple):
		"""タプルを追加する。"""
		self.tup.append(tuple)
		keys = self.attribute.keys()
		values = tuple.values
		if self.kind_string == 'input':
			self.images_names.append(values[keys.index("img")])
			self.thumbnail_names.append(values[keys.index("thum")])
		return None

	def attributes(self):
		"""属性リストを応答する。"""
		return self.attribute

	def image_filenames(self):
		"""画像ファイル群をリストにして応答する。"""
		return self.images_names

	def thumbnail_filenames(self):
		"""縮小画像ファイル群をリストにして応答する。"""
		return self.thumbnail_names
	
	def tuples(self):
		"""タプル群を応答する。"""
		return self.tup

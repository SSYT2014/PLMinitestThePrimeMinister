#! /usr/bin/env python
# -*- coding: utf-8 -*-


__author__ = "Tokuume Shinya<g1244785@cc.kyoto-su.ac.jp>"
__status__ = "production"
__date__ = "22 December 2014"


from primeministers import table
from primeministers import tuple
import io


class Reader(io.IO):
	"""リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。"""

	def __init__(self, csv_file):
		"""リーダのコンストラクタ。"""
		self._csv_file = csv_file
		return

	def table(self):
		"""ダウンロードしたCSVファイルを読み込んでテーブルを応答する。"""
		a_table = table.Table("input")
		attribute = self._csv_file.next()
		for row in self._csv_file:
			values = row
			tup = tuple.Tuple(attribute,values)
			a_table.add(tup)
			
		return a_table

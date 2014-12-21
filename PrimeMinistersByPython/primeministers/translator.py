#! /usr/bin/env python
# -*- coding: utf-8 -*-

import datetime
import os
import re

import table
import tuple

class Translator(object):
	"""トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。"""

	def __init__(self, input_table):
		"""トランスレータのコンストラクタ。"""
		self.a_table = input_table
		return

	def compute_string_of_days(self, period):
		"""在位日数を計算して、それを文字列にして応答する。"""
		days = re.split('[～年月日]*',period)
		days.pop()
		days[3:4] = []
		print days
		days = map(int,days)
		from_day = datetime.date(days[0], days[1], days[2])
		if len(days) > 4:
			to_day = datetime.date(days[3], days[4], days[5])
		else:
			d = datetime.datetime.today()
			to_day = datetime.date(d.year, d.month, d.day)
		diff = to_day - from_day + datetime.timedelta(days=1)
		return str(diff.days)

	def compute_string_of_image(self, tuple):
		"""サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。"""
		attribute_key = self.a_table.attributes().keys()
		values = tuple.values
		image = values[attribute_key.index('img')]
		thumbnail = values[attribute_key.index('thum')]
		imagename = re.split('/',str(image))
		a_str = '<a name="39" href="'+str(image)+'"><img class="borderless" src="'+str(thumbnail)+'" width="25" height="32" alt=“'+str(imagename[1])+'”></a>'
		return a_str

	def table(self):
		"""総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。"""
		out_table = table.Table('output')
		attribute_out = out_table.attributes().keys()
		attribute_key = self.a_table.attributes().keys()
		tup = self.a_table.tuples()
		for tuple in tup:
			values = tuple.values
			print values
			period = self.compute_string_of_days(values[attribute_key.index('util')])
			a_link = a_link = self.compute_string_of_image(tuple)
			values.insert(attribute_out.index('period'),period)
			values.insert(attribute_out.index('link'),a_link)
			values[attribute_out.index('img'):attribute_out.index('link')] = []
			tuple.set_values(values)
			tuple.set_attributes(attribute_out)
			out_table.add(tuple)
		return out_table

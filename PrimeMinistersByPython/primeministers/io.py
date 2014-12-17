#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv

class IO(object):
	"""入出力：リーダ・ダウンローダ・ライタを抽象する。"""
		
	"""指定されたファイルをCSVとして読み込む """
	def read_csv(self,filename):
		csv_file = csv.reader(open(filename,'rU'),delimiter=',',quotechar='"')
		return csv_file
	"""指定されたファイルにCSVとして行立ちを書き出す """
	def write_csv(self,filename,rows):
		return None
		

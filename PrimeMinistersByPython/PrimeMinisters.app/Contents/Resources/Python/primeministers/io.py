#! /usr/bin/env python
# -*- coding: utf-8 -*-

import csv

class IO(object):
	"""入出力：リーダ・ダウンローダ・ライタを抽象する。"""
	
	def read_csv(self, filename):
		"""指定されたファイルをCSVとして読み込む。"""
		a_file = open(filename+".csv","r")
		a_reader = csv.reader(a_file)
		for row in reader:
			print row
		return one
	
	def write_csv(self, filename, rows):
		"""指定されたファイルにCSVとして行たち(rows)を書き出す。"""
		a_file = open(filename,"w")
		for line in rows:
			a_file.write(line)
		a_file.close()
		return a_file

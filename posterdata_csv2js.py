# -*- coding: utf-8 -*-
# ポスターデータをCSVからJSに変換するだけの簡単なスクリプト ver 1.0
# author: Shota Furuya

import sys
import codecs
import csv
import json

fi = codecs.open('poster.csv', 'r', 'utf-8')

lines = []

for line in fi:
	lines.append(line)

fi.close()

parts = [""] * len(lines)

for i in range(len(lines)):
	parts[i] = lines[i].split(',')

keys = parts.pop(0)

dicts = [""] * len(parts)

for i in range(len(parts)):
	dicts[i] = {}
	for j in range(len(keys)):
		dicts[i][keyes[j]] = parts[i][j]

fo = codecs.open('posterdata.json', 'w', 'utf-8')

json.dump(dicts, fo, )
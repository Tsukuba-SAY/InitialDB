// CSVに格納されたポスターデータをJSONに変換して保存するだけの簡単なスクリプト
// author: Shota Furuya
// date: 2014/07/15
// usage: $ node posterdata2json.js [CSV file name]

// csonv.js をお借りしました
// https://github.com/archan937/csonv.js
// License: MIT License

posterdata2json(process.argv);

function posterdata2json(argv) {
	var Csonv = require("Csonv");
	var posters = Csonv.fetch(argv[2]);
	var result = JSON.stringify(posters, null, 2);
	print(result);
}

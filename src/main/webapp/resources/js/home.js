
$(document).ready(function () {
	$("#search").click(function () {
		console.log("click")
		//sent data in  search input to controller and get data json response
		$.ajax({
			url: context + '/search',
			dataType: 'json',
			type: 'post',
			data: { text: $("#text").val() },
			success: function (result) {
				let content = JSON.parse(JSON.stringify(result))
				console.log(content)
				if (content == null || content == "") {
					alert("Empty content....!")
				}
				//append row data to table
				insertInfor(content);

			},
			error: function () {
				alert("error");
			}
		})
	});


	$("#view-content").click(function () {
		console.log("click...")
		//get data json from response
		$.ajax({
			type: 'post',
			dataType: 'json',
			url: context + '/view',
			success: function (result) {
				let content = JSON.parse(JSON.stringify(result)) //JSON.parse(result)
				if (content == null || content == "") {
					alert("Empty content....!")
				}
				console.log(content);
				insertInfor(content);

			}
		});
	});

	$("#delete").click(function () {
		console.log($("#delete"))
		//get data json from response
		$.ajax({
			type: 'post',
			dataType: 'json',
			data: {
				//id = data.
			},
			url: 'view',
			success: function (result) {
				content = JSON.parse(JSON.stringify(result))
				if (content == null || content == "") {
					alert("Empty content....!")
				}
				console.log(content);
				insertInfor(content);

			}
		});
	});

	$("#button").click(function () {
		let button = $("#content-button").text();
		console.log(button)
		if (button === "Edit") {
			$.ajax({
				url: context + '/edit',
				dataType: 'json',
				type: 'post',
				data: {
					title: $("#title").val(),
					brief: $("#brief").val(),
					content: $("#content").val(),
					sort: $("#sort").val(),
				},
				success: function (result) {
					let content = JSON.parse(JSON.stringify(result))
					console.log(content)
					if (content == null || content == "") {
						alert("Empty content....!")
					}
					//append row data to table
					insertInfor(content);

				},
				error: function () {
					alert("error");
				}
			})
		}
	});

});


function insertInfor(content) {
	$(".content").remove();
	$(".profile").remove();
	$("#tbl-result tr > td").remove();
	// get element tbody of table with id = tbl-result
	let table = document.getElementById("tbl-result").getElementsByTagName("tbody")[0];

	console.log(content.length)
	// insert content rows into table result
	let count = 0;
	for (let i = 0; i < content.length; i++) {
		console.log(content[i].title)
		let row = table.insertRow(table.rows.length);
		row.insertCell(0).innerHTML = content[i].id;
		row.insertCell(1).innerHTML = content[i].title;
		row.insertCell(2).innerHTML = content[i].brief;
		row.insertCell(3).innerHTML = content[i].content;
		row.insertCell(4).innerHTML = content[i].createDate;
		row.insertCell(5).innerHTML = '<td><a href="' + context + '/edit/' + content[i].id + '">Edit</a></td>';
		row.insertCell(6).innerHTML = '<td><a id="delete" href="' + context + '/delete/' + content[i].id + '">Delete</a></td>';

	}

}


$(document).ready(function () {
	$("#form").submit(function () {
		console.log("lick")
		let title = $("#title").val();
		let brief = $("#brief").val();
		let content = $("#content").val();
		if (title != '' && brief != '' && content != '') {
			return true;
		}
		alert("All field must input...")
		return false;
	});

});
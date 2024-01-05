

function makeTemp() {
	console.log("woek");

	var formData = $('#xmlForm').serialize(); // 폼 데이터를 직렬화합니다.

	$.ajax({
		type: 'POST',
		url: '/create', // 서버의 처리 URL을 입력합니다.
		data: formData,
		success: function(response) {
			// 서버에서의 응답 처리
			console.log('Success:', response);
			alert("저장되었습니다.")
		},
		error: function(error) {
			// 오류 처리
			console.log('Error:', error);
		}
	});
}


function toggleAccordion() {
	const clickedItem = this.closest("li");
	const items = clickedItem.parentNode.querySelectorAll("li");

	items.forEach((item) => {
		if (clickedItem === item) {
			item.classList.toggle("on");
		} else {
			item.classList.remove("on");
		}
	});
}





document.addEventListener("DOMContentLoaded", function() {
	const accordions = document.querySelectorAll(".accordion");

	accordions.forEach((accordion) => {
		const titles = accordion.querySelectorAll(".title");
		titles.forEach((title) => {
			title.addEventListener("click", toggleAccordion);
		});
	});
});

const add_textbox = () => {
	const box = document.getElementById("box");
	console.log("눌러짐");

	const newP = document.createElement('div');
	newP.innerHTML = '<div class="accordion"><ul><li class="on"><div class="title"><span>New Archive</span></div><strong><p style="font-size: 23px;">Agent</p></strong>'
		+ '<div class="row" id="hello"><div class="col-md-3"><label for="arch-name" class="form-label">name</label><input type="text" class="form-control" name="" th:value="${archive.ag_Name}" id="arch-name"></div><div class="col-md-3"><label for="arch-type" class="form-label">type</label><input type="text" class="form-control" name="" th:value="${archive.ag_Type}" id="arch-type"></div>'
		+ '<div class="col-6"><label for="arch-age-class" class="form-label">class</label><input type="text" class="form-control" name="" th:value="${archive.ag_class}" id="arch-age-class"></div></div><div class="row"><div class="col-md-6"><label for="arch-opclass" class="form-label">opclass</label><input type="text" class="form-control" name="" th:value="${archive.ag_Opclass}" id="arch-opclass"></div>'
		+ '<div class="col-md-6"><label for="arch-msgfile" class="form-label">msgfile</label><input type="text" class="form-control" name="" th:value="${archive.ag_Msgfile}" id="arch-msgfile"></div></div><strong><p style="font-size: 23px;">scheduler</p></strong><div class="row" id="hello"><div class="col-md-12"><label for="arch-shc-class" class="form-label">class</label><input type="text" class="form-control" name="" value="" id="arch-shc-class"></div></div>'
		+ '<strong><p style="font-size: 23px;">device-if</p></strong><div class="row" id="hello"><div class="col-md-4"><label for="arch-shc-class" class="form-label">class</label><input type="text" class="form-control" name="" value="" id="arch-shc-class"></div><div class="col-md-4"><label for="arch-basedir" class="form-label">basedir</label><input type="text" class="form-control" name="" value="" id="arch-basedir"></div><div class="col-md-4"><label for="arch-hashdirs" class="form-label">hashdirs</label><input type="text" class="form-control" name="" value="" id="arch-hashdirs"></div></div>'
		+ '<div class="row"><div class="col-md-4"><label for="arch-dateformat" class="form-label">dateformat</label><input type="text" class="form-control" name="" value="" id="arch-dateformat"></div>'
		+ '<div class="col-md-4"><label for="arch-filesystemclass" class="form-label">filesystemclass</label><input type="text" class="form-control" name="" value="" id="arch-filesystemclass"></div><div class="col-md-4"><label for="arch-filesystemkb" class="form-label">filesystemkb</label><input type="text" class="form-control" name="" value="" id="arch-filesystemkb"></div></div>'
		+ '<strong><p style="font-size: 23px;">threadpool</p></strong><div class="row" id="hello"><div class="col-md-6"><label for="arch-ops" class="form-label">ops</label><input type="text" class="form-control" name="" value="" id="arch-ops"></div><div class="col-md-6"><label for="arch-count" class="form-label">count</label><input type="text" class="form-control" name="" value="" id="count"></div> </div></li></ul></div>';


	box.appendChild(newP);

	console.log(box.lastElementChild);
	const newAccordion = box.lastElementChild;
	const newTitles = newAccordion.querySelectorAll(".title");
	newTitles.forEach((title) => {
		title.addEventListener("click", toggleAccordion);
	});
}

const remove = (obj) => {
	document.getElementById('box').removeChild(obj.parentNode);
}


// 버튼 클릭 시  아카이브 바뀜

function show_btn(element) {
	let tag = document.getElementsByClassName("box");

	for (let i = 0; i < tag.length; i++) {
		if (element.id + "show" == tag[i].id) {
			tag[i].style.display = "block";
			tag[i].style.animation = "fadeIn";
			tag[i].style.animationDuration = "1s";

		} else {
			tag[i].style.display = "none";
		}
	}
}


function valueChange() {

	var dbtype = document.getElementById("dbtype").selectedIndex;
	console.log(dbtype);


	var newDriver = "";


	if (dbtype == '0') {
		newDriver = "com.jnetdirect.jsql.JSQLDriver";
	} else if (dbtype == '1') {
		newDriver = "oracle.jdbc.driver.OracleDriver";
	} else if (dbtype == '2') {
		newDriver = "com.ibm.db2.jcc.DB2Driver";
	} else if (dbtype == '3') {
		newDriver = "com.mysql.cj.jdbc.Driver";
	} else if (dbtype == '4') {
		newDriver = "org.mariadb.jdbc.Driver";
	} else if (dbtype == '5') {
		newDriver = "com.tmax.tibero.jdbc.TbDriver";
	} else if (dbtype == '6') {
		newDriver = "org.postgresql.Driver";
	};


	document.getElementById("driver").value = newDriver;
	console.log(newDriver);

};


function validateNumberInput(inputField) {
	// 정규표현식을 사용하여 숫자 및 특수 문자를 필터링
	inputField.value = inputField.value.replace(/[^a-zA-Z가-힣./_:@\s]/g, '');
}


function validateCharInput(inputField) {
	// 정규표현식을 사용하여 숫자 및 특수 문자를 필터링
	inputField.value = inputField.value.replace(/[^0-9.]/g, '');
}

function validateEngInput(inputField) {
	// 정규표현식을 사용하여 숫자 및 특수 문자를 필터링
	inputField.value = inputField.value.replace(/[^a-zA-Z]/g, '');
}

// 배열로 변경
let values = [];
var element = document.querySelector('.changeColor');

function logValueOnClick(index, inputField) {
	// value2가 이미 초기화되어 있다면 초기화하지 않도록 확인
	if (typeof values[index] === 'undefined') {
		values[index] = inputField.value;
	}
}

function myFunction(index, inputField) {
	let value = inputField.value;
	console.log(`Changed value ${index}: ` + value);


	if (value !== values[index]) {
		inputField.style.color = "red";
		if ([index] == 30) {
			element.style.color = "red";
		}

	} else {
		inputField.style.color = "black";
		if ([index] == 30) {
			element.style.color = "black";
		}
	}
}

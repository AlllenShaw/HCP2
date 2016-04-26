function getpatientinfo() {
		$.ajax({
					url : "??.do",
					data : {
						"userid" : $("#userid").val()
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
							var result=eval(data);
							document.getElementById("username").value=result.username;
							document.getElementById("realname").value=result.realname;
							document.getElementById("gender").value=result.gender;
							document.getElementById("nation").value=result.nation;
							document.getElementById("age").value=result.age;
							document.getElementById("marriage").value=result.marriage;
							document.getElementById("profession").value=result.profession;
							document.getElementById("id2").value=result.Id_number;
							document.getElementById("hin").value=result.hin;
							document.getElementById("eduction").value=result.eduction;
							document.getElementById("address").value=result.bir_address;
							document.getElementById("naddress").value=result.address;
							document.getElementById("company").value=result.company;
							document.getElementById("tele").value=result.tele;
							document.getElementById("email").value=result.mail;
							document.getElementById("Hospital").value=result.hospital;
							document.getElementById("Doctor").value=result.username;
							document.getElementById("htnstate").value=result.htn_state;
							document.getElementById("glustate").value=result.glu_state;
							document.getElementById("hplstate").value=result.hpl_state;
							document.getElementById("illnesshistory").value=result.illness_his;
							document.getElementById("allergichistory").value=result.allergic_his;
							document.getElementById("familymedicalhistory").value=result.family_his;
							
						}
					}
				});
				
				
				
function getdoctorinfo() {
		$.ajax({
					url : "??.do",
					data : {
						"userid" : $("#userid").val()
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
							var result=eval(data);
							document.getElementById("username").value=result.username;
							document.getElementById("realname").value=result.realname;
							document.getElementById("gender").value=result.gender;
							document.getElementById("nation").value=result.nation;
							document.getElementById("age").value=result.age;
							document.getElementById("id2").value=result.id_number;
							document.getElementById("naddress").value=result.address;
							document.getElementById("tele").value=result.tele;
							document.getElementById("mail").value=result.mail;
							document.getElementById("hospital_id").value=result.hospital_id;
							document.getElementById("certificate").value=result.doctor_license;
							document.getElementById("belongdepart").value=result.profession;
							document.getElementById("selfintroduce").value=result.??;
						}
					}
				});
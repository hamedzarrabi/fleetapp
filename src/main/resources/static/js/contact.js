/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(contact, status){
			
			$('#idEdit').val(contact.id);
			$('#txtFirstnameEdit').val(contact.firstname);
			$('#txtLastnameEdit').val(contact.lastname);
			$('#txtEmailEdit').val(contact.email);
			$('#txtMobileEdit').val(contact.mobile);
			$('#txtPhoneEdit').val(contact.phone);
			$('#txtRemarksEdit').val(contact.remarks);

			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (contact, status) {


			$('#detailsId').val(contact.id);
			$('#txtFirstnameDetails').val(contact.firstname);
			$('#txtLastnameDetails').val(contact.lastname);
			$('#txtEmailDetails').val(contact.email);
			$('#txtMobileDetails').val(contact.mobile);
			$('#txtPhoneDetails').val(contact.phone);
			$('#txtRemarksDetails').val(contact.remarks);


		});
		$('#detailsModal').modal();
	});
	
	
	
	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
		
	});
	
	
});
$
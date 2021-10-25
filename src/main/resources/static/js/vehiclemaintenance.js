/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclemaintenance, status){
			
			$('#idEdit').val(vehiclemaintenance.id);
			$('#vehicleEdit').val(vehiclemaintenance.vehicleid);
			$('#startDateEdit').val(vehiclemaintenance.startDate);
			$('#remarksEdit').val(vehiclemaintenance.remarks);
			$('#endDateEdit').val(vehiclemaintenance.endDate);
			$('#txtPhoneEdit').val(vehiclemaintenance.supplier);
			$('#txtRemarksEdit').val(vehiclemaintenance.remarks);

			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (vehiclemaintenance, status) {


			$('#idDetails').val(vehiclemaintenance.id);
			$('#vehicleDetails').val(vehiclemaintenance.vehicleid);
			$('#startDateDetails').val(vehiclemaintenance.startDate);
			$('#remarksDetails').val(vehiclemaintenance.remarks);
			$('#endDateDetails').val(vehiclemaintenance.endDate);
			$('#txtPhoneDetails').val(vehiclemaintenance.supplier);
			$('#txtRemarksDetails').val(vehiclemaintenance.remarks);


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
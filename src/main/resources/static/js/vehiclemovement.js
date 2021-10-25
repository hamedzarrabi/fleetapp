/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclemovement, status){
			
			$('#idEdit').val(vehiclemovement.id);
			$('#vehicleEdit').val(vehiclemovement.vehicleid);
			$('#locationEdit1').val(vehiclemovement.locationid1);
			$('#locationEdit2').val(vehiclemovement.locationid2);

			var date1 = VehicleMovement.date1.substr(0, 10);
			var date2 = VehicleMovement.date2.substr(0, 10);

			$('#date1Edit').val(date1);
			$('#date2Edit').val(date2);
			$('#remarksEdit').val(vehiclemovement.remarks);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (vehiclemovement, status) {

	$('#idDetails').val(vehiclemovement.id);
			$('#vehicleDetails').val(vehiclemovement.vehicleid);
			$('#location1Details').val(vehiclemovement.locationid1);
			$('#location2Details').val(vehiclemovement.locationid2);

			var date1 = VehicleMovement.date1.substr(0, 10);
			var date2 = VehicleMovement.date2.substr(0, 10);

			$('#date1Details').val(date1);
			$('#date2Details').val(date2);
			$('#remarksDetails').val(vehiclemovement.remarks);


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
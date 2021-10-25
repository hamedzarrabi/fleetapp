/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclehire, status){
			
			$('#idEdit').val(vehiclehire.id);
			$('#clientEdit').val(vehiclehire.clientid);

			var dateIn = vehiclehire.datein.substr(0, 10);
			var dateOut = vehiclehire.dateout.substr(0, 10);

			$('#dateInEdit').val(dateIn);
			$('#dateOutEdit').val(dateout);

			$('#timeInEdit').val(vehiclehire.timein);
			$('#timeOutEdit').val(vehiclehire.timeout);

			$('#locationEdit2').val(vehiclehire.locationid);
			$('#priceEdit').val(vehiclehire.price);
			$('#remarksEdit').val(vehiclehire.remarks);
			$('#vehicleEdit').val(vehiclehire.vehicleid);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
			$.get(href, function (vehiclehire, status) {

				$('#idDetails').val(vehiclehire.id);
				$('#clientEdit').val(vehiclehire.clientid);

				var dateIn = vehiclehire.datein.substr(0, 10);
				var dateOut = vehiclehire.dateout.substr(0, 10);

				$('#dateInDetails').val(dateIn);
				$('#dateOutDetails').val(dateout);

				$('#timeInDetails').val(vehiclehire.timein);
				$('#timeOutDetails').val(vehiclehire.timeout);

				$('#locationDetails').val(vehiclehire.locationid);
				$('#priceDetails').val(vehiclehire.price);
				$('#remarksDetails').val(vehiclehire.remarks);
				$('#vehicleDeatils').val(vehiclehire.vehicleid);


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
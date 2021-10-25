/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehicle, status){

			var acDate = vehicle.acquisitionDate.substr(0, 10);
			$('#acquisitionDateEdit').val(vehicle.acquisitionDate);
			$('#descriptionEdit').val(vehicle.description);


			$('#employeeidEdit').val(vehicle.employeeid);
			$('#fuelCapacityEdit').val(vehicle.fuelCapacity);

			$('#idEdit').val(vehicle.id);
			$('#locationEdit').val(vehicle.locationid);
			$('#nameEdit').val(vehicle.name);
			$('#netWeightEdit').val(vehicle.netWeight);
			$('#powerEdit').val(vehicle.power);
			var regDate = vehicle.registrationDate.substr(0, 10);
			$('#registrationDateEdit').val(vehicle.registrationDate);
			$('#remarksEdit').val(vehicle.remarks);
			$('#vehiclemakeEdit').val(vehicle.vehiclemakeid);
			$('#vehicleModelEdit').val(vehicle.vehiclemodelid);
			$('#vehicleNumberEdit').val(vehicle.vehicleNumber);
			$('#statusEdit').val(vehicle.vehiclestatusid);
			$('#vehicleTypeEdit').val(vehicle.vehicletypeid);
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
			$.get(href, function (vehicle, status) {
				var acDate = vehicle.acquisitionDate.substr(0, 10);
				$('#acquisitionDateDetails').val(vehicle.acquisitionDate);
				$('#descriptionDetails').val(vehicle.description);


				$('#employeeidEdit').val(vehicle.employeeid);
				$('#fuelCapacityDetails').val(vehicle.fuelCapacity);

				$('#idDetails').val(vehicle.id);
				$('#locationDetails').val(vehicle.locationid);
				$('#nameDetails').val(vehicle.name);
				$('#netWeightDetails').val(vehicle.netWeight);
				$('#powerDetails').val(vehicle.power);
				var regDate = vehicle.registrationDate.substr(0, 10);
				$('#registrationDateDetails').val(vehicle.registrationDate);
				$('#remarksDeatails').val(vehicle.remarks);
				$('#vehiclemakeDeatails').val(vehicle.vehiclemakeid);
				$('#vehicleModelDetails').val(vehicle.vehiclemodelid);
				$('#vehicleNumberEDetails').val(vehicle.vehicleNumber);
				$('#statusDetails').val(vehicle.vehiclestatusid);
				$('#vehicleTypeDetails').val(vehicle.vehicletypeid);

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
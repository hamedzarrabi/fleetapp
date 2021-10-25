/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehicleModel, status){
			
			$('#idEdit').val(vehicleModel.id);
			$('#nameEdit').val(vehicleModel.description);
			$('#detailsEdit').val(vehicleModel.details);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (vehicleModel, status) {
			$('#idDetails').val(vehicleModel.id);
			$('#nameDetails').val(vehicleModel.description);
			$('#detailsDetails').val(vehicleModel.details);
			$('#createdByDetails').val(vehicleModel.createdBy);
			$('#createdDateDetails').val(vehicleModel.createDate);
			$('#lastModifiedUpdateByDetails').val(vehicleModel.lastModifiedDate);
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
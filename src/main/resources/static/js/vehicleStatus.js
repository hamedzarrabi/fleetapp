/**
 *
 */

$('document').ready(function(){

	$('.table #editButton').on('click', function(event){

		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(vehicleType, status){

			$('#idEdit').val(vehicleType.id);
			$('#nameEdit').val(vehicleType.description);
			$('#detailsEdit').val(vehicleType.details);

		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (vehicleType, status) {
			$('#idDetails').val(vehicleType.id);
			$('#nameDetails').val(vehicleType.description);
			$('#detailsDetails').val(vehicleType.details);
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

// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function  cargarUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
   
  });
  const usuarios = await request.json();
  //console.log(usuarios);
  let listHTML ='';

  for (let user of usuarios){
    let usuarioHTML = ' <tr>\n' +
        '                                            <td>12</td>\n' +
        '                                            <td>'+user.nombre+'</td>\n' +
        '                                            <td>'+user.email+'</<td>\n' +
        '                                            <td>'+user.telefono+'</td>\n' +
        '                                            <td>\n' +
        '                                                <a href="#" class="btn btn-danger btn-circle">\n' +
        '                                                    <i class="fas fa-trash"></i>\n' +
        '                                                </a>\n' +
        '                                            </td>\n' +
        '                                    </tbody>\n' +
        '                                    </tr>';

    listHTML+= usuarioHTML

  }


  document.querySelector('#usuarios tbody').outerHTML = listHTML;
}

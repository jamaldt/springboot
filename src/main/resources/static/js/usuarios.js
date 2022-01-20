// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function  cargarUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeaders()
   
  });
  const usuarios = await request.json();
  //console.log(usuarios);
  let listHTML ='';
  for (let user of usuarios){
    let botonEliminar = '<a href="#" onclick="eliminarUsuario('+user.id+')" class="btn btn-danger btn-circle">\n' +
        '<i class="fas fa-trash"></i>\n' +
        '</a>\n' ;

    let telefono = user.telefono == null? '-' : user.telefono;

    let usuarioHTML = ' <tr>\n' +
        '                                            <td>12</td>\n' +
        '                                            <td>'+user.nombre+'</td>\n' +
        '                                            <td>'+user.email+'</<td>\n' +
        '                                            <td>'+telefono+'</td>\n' +
        '                                            <td>\n' + botonEliminar+
        '                                            </td>\n' +
        '                                    </tbody>\n' +
        '                                    </tr>';

    listHTML+= usuarioHTML

  }
  document.querySelector('#usuarios tbody').outerHTML = listHTML;
}

function getHeaders(){
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization':localStorage.token
  };
}

async function eliminarUsuario(id){
  if (!confirm('Desa elminar el user')){
    return;
  }

  const request = await fetch('api/usuarios/'+id, {
    method: 'DELETE',
    headers: getHeaders()

  });
  location.reload()
}
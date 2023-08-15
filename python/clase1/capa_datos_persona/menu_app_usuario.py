from capa_datos_persona.usuario_dao import UsuarioDao
from logger_base import Log
from capa_datos_persona.usuario import Usuario

opcion = None
while opcion != 5:
    print('Opciones')
    print('1. listar Usuarios')
    print('2. Registrar Usuario')
    print('3. Modificar Usuario')
    print('4. Eliminar Usuario')
    print('5. Salir')
    opcion = int(input('Ingrese una opcion (1-5): '))
    if opcion == 1:
        usuarios = UsuarioDao.seleccionar()
        for usuario in usuarios:
            log.info(usuario)
    elif opcion == 2:
        username_var = input('Digite el nombre de usuario:')
        password_var = input('Digite la contraseña:')
        usuaruo = Usuario(username=username_var, password=password_var)
        usuario_insertado = UsuarioDao.insertar(usuario)
        log.info(f'Usuario insertado: {usuario_insertado}')
    elif opcion == 3:
        id_usuario_var = int(input('Digite el id del usuario a modificar: '))
        username_var = input('Digite el nuevo nombre de usuario a modificar:')
        password_var = input('Digite la nueva contraseña a modificar:')
        usuario = Usuario(id_usuario=id_usuario_var, username= username_var, password= password_var)
        usurio_modificado = UsuarioDao.actualizar(usuario)
        log.info(f'Usuario modificado: {usurio_modificado}')
    elif opcion == 4:
        id_usuario_var = int(input('Digite el id del usuario a eliminar: '))
        usuario = Usuario(id_usuario=id_usuario_var)
        usuario_eliminado = UsuarioDao.eliminar(usuario)
        log.info(f'Usuario eliminado: {usuario_eliminado}')

else:
    log.info('Salimos de la aplicaión., Hasta Pronto')

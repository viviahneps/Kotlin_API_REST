package br.com.alura.aluraforum.exception

import br.com.alura.aluraforum.DTOS.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler( NotFoundException :: class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun HandlerNotfound(
         exception : NotFoundException,
         request : HttpServletRequest
    ) : ErrorView {
     return ErrorView (
         status = HttpStatus.NOT_FOUND.value(),
         error = HttpStatus.NOT_FOUND.name,
         message = exception.message,
         path =  request.contextPath
             )
    }
    @ExceptionHandler( MethodArgumentNotValidException :: class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun HandlerErrorVallidation(
        exception : MethodArgumentNotValidException,
        request : HttpServletRequest
    ) : ErrorView {
        val errormessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
                e -> errormessage.put(e.field, e.defaultMessage)
        }
        return ErrorView (
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errormessage.toString(),
            path =  request.contextPath
        )
    }

    @ExceptionHandler( Exception :: class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun HandlerServerError(
        exception : Exception,
        request : HttpServletRequest
    ) : ErrorView {
        return ErrorView (
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message,
            path =  request.contextPath
        )
    }



}
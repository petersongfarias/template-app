package br.com.commons_network.mapper

@Suppress("UNCHECKED_CAST")
class Mappers(private vararg val mappers: Mapper<*, *>) {

    fun <TSource : Any, TTarget : Any> mapTo(source: TSource): TTarget {
        mappers.forEach { mapper ->
            mapper.mapTo(this, source)?.let {
                return it as TTarget
            }
        }

        throw MapperNotFoundException()
    }
}

class MapperNotFoundException : Throwable("TSource mapper not found")

fun <TSource : Any, TTarget : Any> TSource.mapTo(mappers: Mappers): TTarget = mappers.mapTo(this)

fun <TSource : Any, TTarget : Any> List<TSource>.mapTo(mappers: Mappers): List<TTarget> =
    this.map { it.mapTo(mappers) }

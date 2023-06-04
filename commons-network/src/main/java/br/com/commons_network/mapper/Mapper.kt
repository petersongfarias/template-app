package br.com.commons_network.mapper

import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class Mapper<TSource : Any, TTarget : Any>(
    private val sourceClass: KClass<TSource>,
    private val map: TSource.(Mappers) -> TTarget,
) {
    fun mapTo(mappers: Mappers, source: Any): TTarget? =
        if (sourceClass.isInstance(source)) (source as TSource).map(mappers) else null
}

inline fun <reified TSource : Any, reified TTarget : Any> mapper(noinline map: TSource.(Mappers) -> TTarget) =
    Mapper(TSource::class, map)

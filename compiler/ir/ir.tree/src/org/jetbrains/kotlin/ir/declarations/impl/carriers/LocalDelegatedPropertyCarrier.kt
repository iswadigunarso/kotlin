/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations.impl.carriers

import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall

interface LocalDelegatedPropertyCarrier : DeclarationCarrier<LocalDelegatedPropertyCarrier> {
    var delegateField: IrVariable?
    var getterField: IrFunction?
    var setterField: IrFunction?
    var metadataField: MetadataSource.LocalDelegatedProperty?

    override fun clone(): LocalDelegatedPropertyCarrier {
        return LocalDelegatedPropertyCarrierImpl(
            lastModified,
            parentField,
            originField,
            annotationsField,
            delegateField,
            getterField,
            setterField,
            metadataField
        )
    }
}

class LocalDelegatedPropertyCarrierImpl(
    override val lastModified: Int,
    override var parentField: IrDeclarationParent?,
    override var originField: IrDeclarationOrigin,
    override var annotationsField: List<IrConstructorCall>,
    override var delegateField: IrVariable?,
    override var getterField: IrFunction?,
    override var setterField: IrFunction?,
    override var metadataField: MetadataSource.LocalDelegatedProperty?
) : LocalDelegatedPropertyCarrier
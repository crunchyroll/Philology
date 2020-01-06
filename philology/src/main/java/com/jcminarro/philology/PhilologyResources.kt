package com.jcminarro.philology

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.res.AssetFileDescriptor
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.content.res.TypedArray
import android.content.res.XmlResourceParser
import android.graphics.Movie
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.annotation.RequiresApi
import java.io.InputStream

@Suppress("DEPRECATION")
internal class PhilologyResources(
    private val baseResources: Resources
) : Resources(baseResources.assets, baseResources.displayMetrics, baseResources.configuration) {
    private val resourcesUtil = ResourcesUtil(baseResources)

    override fun getText(id: Int): CharSequence = resourcesUtil.getText(id)

    override fun getText(id: Int, def: CharSequence): CharSequence = try {
        getText(id)
    } catch (_: NotFoundException) {
        def
    }

    override fun getString(id: Int): String = resourcesUtil.getString(id)

    override fun getQuantityText(id: Int, quantity: Int): CharSequence =
        resourcesUtil.getQuantityText(id, quantity)

    override fun getQuantityString(id: Int, quantity: Int): String =
        resourcesUtil.getQuantityString(id, quantity)

    override fun getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any?): String =
        resourcesUtil.getQuantityString(id, quantity, *formatArgs)

    override fun getStringArray(id: Int): Array<String> = resourcesUtil.getStringArray(id)

    override fun getTextArray(id: Int): Array<CharSequence> = resourcesUtil.getTextArray(id)

    override fun getAnimation(id: Int): XmlResourceParser = baseResources.getAnimation(id)

    override fun getDisplayMetrics(): DisplayMetrics = baseResources.displayMetrics

    override fun getDrawableForDensity(id: Int, density: Int): Drawable? =
        baseResources.getDrawableForDensity(id, density)

    @TargetApi(VERSION_CODES.LOLLIPOP)
    override fun getDrawableForDensity(id: Int, density: Int, theme: Theme?): Drawable? =
        baseResources.getDrawableForDensity(id, density, theme)

    override fun getConfiguration(): Configuration = baseResources.configuration

    override fun obtainAttributes(set: AttributeSet?, attrs: IntArray?): TypedArray {
        return baseResources.obtainAttributes(set, attrs)
    }

    override fun getDimensionPixelSize(id: Int): Int = baseResources.getDimensionPixelSize(id)

    override fun getIntArray(id: Int): IntArray = baseResources.getIntArray(id)

    override fun getValue(id: Int, outValue: TypedValue?, resolveRefs: Boolean) {
        baseResources.getValue(id, outValue, resolveRefs)
    }

    override fun getValue(name: String?, outValue: TypedValue?, resolveRefs: Boolean) {
        baseResources.getValue(name, outValue, resolveRefs)
    }

    override fun getResourcePackageName(resid: Int): String =
        baseResources.getResourcePackageName(resid)

    override fun openRawResourceFd(id: Int): AssetFileDescriptor =
        baseResources.openRawResourceFd(id)

    override fun getDimension(id: Int): Float = baseResources.getDimension(id)

    override fun getColorStateList(id: Int): ColorStateList = baseResources.getColorStateList(id)

    @TargetApi(VERSION_CODES.M)
    override fun getColorStateList(id: Int, theme: Theme?): ColorStateList =
        baseResources.getColorStateList(id, theme)

    override fun getBoolean(id: Int): Boolean = baseResources.getBoolean(id)

    override fun getIdentifier(name: String?, defType: String?, defPackage: String?): Int =
        baseResources.getIdentifier(name, defType, defPackage)

    override fun getColor(id: Int): Int = baseResources.getColor(id)

    @TargetApi(VERSION_CODES.M)
    override fun getColor(id: Int, theme: Theme?): Int = baseResources.getColor(id, theme)

    override fun openRawResource(id: Int): InputStream = baseResources.openRawResource(id)

    override fun openRawResource(id: Int, value: TypedValue?): InputStream =
        baseResources.openRawResource(id, value)

    override fun getMovie(id: Int): Movie = baseResources.getMovie(id)

    override fun getInteger(id: Int): Int = baseResources.getInteger(id)

    override fun parseBundleExtras(parser: XmlResourceParser?, outBundle: Bundle?) {
        this.baseResources.parseBundleExtras(parser, outBundle)
    }

    override fun getDrawable(id: Int): Drawable = baseResources.getDrawable(id)

    @TargetApi(VERSION_CODES.LOLLIPOP)
    override fun getDrawable(id: Int, theme: Theme?): Drawable =
        baseResources.getDrawable(id, theme)

    override fun getResourceTypeName(resid: Int): String = baseResources.getResourceTypeName(resid)

    override fun getLayout(id: Int): XmlResourceParser = baseResources.getLayout(id)

    @RequiresApi(VERSION_CODES.O)
    @SuppressLint("NewApi")
    override fun getFont(id: Int): Typeface = baseResources.getFont(id)

    override fun getXml(id: Int): XmlResourceParser = baseResources.getXml(id)

    override fun getResourceName(resid: Int): String = baseResources.getResourceName(resid)

    override fun parseBundleExtra(tagName: String?, attrs: AttributeSet?, outBundle: Bundle?) {
        baseResources.parseBundleExtra(tagName, attrs, outBundle)
    }

    override fun getDimensionPixelOffset(id: Int): Int = baseResources.getDimensionPixelOffset(id)

    override fun getValueForDensity(
        id: Int,
        density: Int,
        outValue: TypedValue?,
        resolveRefs: Boolean
    ) {
        baseResources.getValueForDensity(id, density, outValue, resolveRefs)
    }

    override fun getResourceEntryName(resid: Int): String =
        baseResources.getResourceEntryName(resid)

    override fun getFraction(id: Int, base: Int, pbase: Int): Float =
        baseResources.getFraction(id, base, pbase)
}

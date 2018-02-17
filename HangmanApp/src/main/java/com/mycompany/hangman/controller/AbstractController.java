package com.mycompany.hangman.controller;

import com.mycompany.hangman.gui.View;
import com.mycompany.hangman.model.Model;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cory
 */
public abstract class AbstractController implements Controller
{

    private final List<View> registeredViews;
    private final List<Model> registeredModels;

    public AbstractController()
    {
        registeredViews = new ArrayList<>();
        registeredModels = new ArrayList<>();
    }

    @Override
    public void addModel(Model model)
    {
        registeredModels.add(model);
        model.addPropertyChangeListener(this);
    }

    @Override
    public void removeModel(Model model)
    {
        registeredModels.remove(model);
        model.removePropertyChangeListener(this);
    }

    @Override
    public void addView(View view)
    {
        registeredViews.add(view);
    }

    @Override
    public void removeView(View view)
    {
        registeredViews.remove(view);
    }

    /**
     * Use this to observe property changes from registered models and propagate
     * them on to all the views.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {

        for (View view : registeredViews)
        {
            view.modelPropertyChange(evt);
        }
    }

    /**
     * This is a convenience method that subclasses can call upon to fire
     * property changes back to the models. This method uses reflection to
     * inspect each of the model classes to determine whether it is the owner of
     * the property in question. If it isn't, a NoSuchMethodException is thrown,
     * which the method ignores.
     *
     * @param propertyName The name of the property.
     * @param newValue     An object that represents the new value of the
     *                     property.
     */
    protected void setModelProperty(String propertyName, Object newValue)
    {

        for (Model model : registeredModels)
        {
            try
            {
                Method method = model.getClass()
                        .getMethod("set" + propertyName, newValue.getClass());
                method.invoke(model, newValue);

            }
            catch (IllegalAccessException ex)
            {
                //  Handle exception.
            }
            catch (IllegalArgumentException ex)
            {
                //  Handle exception.
            }
            catch (NoSuchMethodException ex)
            {
            }
            catch (SecurityException ex)
            {
            }
            catch (InvocationTargetException ex)
            {
            }
        }
    }

}

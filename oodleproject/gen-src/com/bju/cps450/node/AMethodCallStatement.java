/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethodCallStatement extends PStatement
{
    private PExpression _dot_;
    private TId _id_;
    private final LinkedList<PExpression> _params_ = new LinkedList<PExpression>();

    public AMethodCallStatement()
    {
        // Constructor
    }

    public AMethodCallStatement(
        @SuppressWarnings("hiding") PExpression _dot_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") List<?> _params_)
    {
        // Constructor
        setDot(_dot_);

        setId(_id_);

        setParams(_params_);

    }

    @Override
    public Object clone()
    {
        return new AMethodCallStatement(
            cloneNode(this._dot_),
            cloneNode(this._id_),
            cloneList(this._params_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodCallStatement(this);
    }

    public PExpression getDot()
    {
        return this._dot_;
    }

    public void setDot(PExpression node)
    {
        if(this._dot_ != null)
        {
            this._dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dot_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public LinkedList<PExpression> getParams()
    {
        return this._params_;
    }

    public void setParams(List<?> list)
    {
        for(PExpression e : this._params_)
        {
            e.parent(null);
        }
        this._params_.clear();

        for(Object obj_e : list)
        {
            PExpression e = (PExpression) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._params_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dot_)
            + toString(this._id_)
            + toString(this._params_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dot_ == child)
        {
            this._dot_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._params_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dot_ == oldChild)
        {
            setDot((PExpression) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        for(ListIterator<PExpression> i = this._params_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PExpression) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}

/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AClassDef extends PClassDef
{
    private TId _begin_;
    private PExtendsProd _extendsProd_;
    private final LinkedList<PVarDec> _varDec_ = new LinkedList<PVarDec>();
    private final LinkedList<PMethDef> _methDef_ = new LinkedList<PMethDef>();
    private TId _end_;

    public AClassDef()
    {
        // Constructor
    }

    public AClassDef(
        @SuppressWarnings("hiding") TId _begin_,
        @SuppressWarnings("hiding") PExtendsProd _extendsProd_,
        @SuppressWarnings("hiding") List<?> _varDec_,
        @SuppressWarnings("hiding") List<?> _methDef_,
        @SuppressWarnings("hiding") TId _end_)
    {
        // Constructor
        setBegin(_begin_);

        setExtendsProd(_extendsProd_);

        setVarDec(_varDec_);

        setMethDef(_methDef_);

        setEnd(_end_);

    }

    @Override
    public Object clone()
    {
        return new AClassDef(
            cloneNode(this._begin_),
            cloneNode(this._extendsProd_),
            cloneList(this._varDec_),
            cloneList(this._methDef_),
            cloneNode(this._end_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassDef(this);
    }

    public TId getBegin()
    {
        return this._begin_;
    }

    public void setBegin(TId node)
    {
        if(this._begin_ != null)
        {
            this._begin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._begin_ = node;
    }

    public PExtendsProd getExtendsProd()
    {
        return this._extendsProd_;
    }

    public void setExtendsProd(PExtendsProd node)
    {
        if(this._extendsProd_ != null)
        {
            this._extendsProd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._extendsProd_ = node;
    }

    public LinkedList<PVarDec> getVarDec()
    {
        return this._varDec_;
    }

    public void setVarDec(List<?> list)
    {
        for(PVarDec e : this._varDec_)
        {
            e.parent(null);
        }
        this._varDec_.clear();

        for(Object obj_e : list)
        {
            PVarDec e = (PVarDec) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._varDec_.add(e);
        }
    }

    public LinkedList<PMethDef> getMethDef()
    {
        return this._methDef_;
    }

    public void setMethDef(List<?> list)
    {
        for(PMethDef e : this._methDef_)
        {
            e.parent(null);
        }
        this._methDef_.clear();

        for(Object obj_e : list)
        {
            PMethDef e = (PMethDef) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._methDef_.add(e);
        }
    }

    public TId getEnd()
    {
        return this._end_;
    }

    public void setEnd(TId node)
    {
        if(this._end_ != null)
        {
            this._end_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._end_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._begin_)
            + toString(this._extendsProd_)
            + toString(this._varDec_)
            + toString(this._methDef_)
            + toString(this._end_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._begin_ == child)
        {
            this._begin_ = null;
            return;
        }

        if(this._extendsProd_ == child)
        {
            this._extendsProd_ = null;
            return;
        }

        if(this._varDec_.remove(child))
        {
            return;
        }

        if(this._methDef_.remove(child))
        {
            return;
        }

        if(this._end_ == child)
        {
            this._end_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._begin_ == oldChild)
        {
            setBegin((TId) newChild);
            return;
        }

        if(this._extendsProd_ == oldChild)
        {
            setExtendsProd((PExtendsProd) newChild);
            return;
        }

        for(ListIterator<PVarDec> i = this._varDec_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVarDec) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PMethDef> i = this._methDef_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PMethDef) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._end_ == oldChild)
        {
            setEnd((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}

/*
 * Copyright (C) 1988 1999 Greg J. Badros and Alan Borning
 * Copyright (C) 2014 Agens AS
 *
 * Original Smalltalk Implementation by Alan Borning
 * This Java Implementation by Greg J. Badros
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package EDU.Washington.grad.gjb.cassowary;

public class ClLinearInequality extends ClLinearConstraint {

    public ClLinearInequality(ClLinearExpression cle, ClStrength strength,
            double weight) {
        super(cle, strength, weight);
    }

    public ClLinearInequality(ClLinearExpression cle, ClStrength strength) {
        super(cle, strength);
    }

    public ClLinearInequality(ClLinearExpression cle) {
        super(cle);
    }

    public ClLinearInequality(ClVariable clv1, CL.Op op_enum, ClVariable clv2,
            ClStrength strength, double weight) throws ExCLInternalError {
        super(new ClLinearExpression(clv2), strength, weight);
        if (op_enum == CL.Op.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv1);
        } else if (op_enum == CL.Op.LEQ) {
            _expression.addVariable(clv1, -1.0);
        } else
            // the operator was invalid
            throw new ExCLInternalError(
                    "Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClVariable clv1, CL.Op op_enum, ClVariable clv2,
            ClStrength strength) throws ExCLInternalError {
        this(clv1, op_enum, clv2, strength, 1.0);
    }

    public ClLinearInequality(ClVariable clv1, CL.Op op_enum, ClVariable clv2)
            throws ExCLInternalError {
        this(clv1, op_enum, clv2, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClVariable clv, CL.Op op_enum, double val,
            ClStrength strength, double weight) throws ExCLInternalError {
        super(new ClLinearExpression(val), strength, weight);
        if (op_enum == CL.Op.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv);
        } else if (op_enum == CL.Op.LEQ) {
            _expression.addVariable(clv, -1.0);
        } else
            // the operator was invalid
            throw new ExCLInternalError(
                    "Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClVariable clv, CL.Op op_enum, double val,
            ClStrength strength) throws ExCLInternalError {
        this(clv, op_enum, val, strength, 1.0);
    }

    public ClLinearInequality(ClVariable clv, CL.Op op_enum, double val)
            throws ExCLInternalError {
        this(clv, op_enum, val, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle1, CL.Op op_enum,
            ClLinearExpression cle2, ClStrength strength, double weight)
            throws ExCLInternalError {
        super(((ClLinearExpression) cle2.clone()), strength, weight);
        if (op_enum == CL.Op.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addExpression(cle1);
        } else if (op_enum == CL.Op.LEQ) {
            _expression.addExpression(cle1, -1.0);
        } else
            // the operator was invalid
            throw new ExCLInternalError(
                    "Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClLinearExpression cle1, CL.Op op_enum,
            ClLinearExpression cle2, ClStrength strength)
            throws ExCLInternalError {
        this(cle1, op_enum, cle2, strength, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle1, CL.Op op_enum,
            ClLinearExpression cle2) throws ExCLInternalError {
        this(cle1, op_enum, cle2, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClAbstractVariable clv, CL.Op op_enum,
            ClLinearExpression cle, ClStrength strength, double weight)
            throws ExCLInternalError {
        super(((ClLinearExpression) cle.clone()), strength, weight);
        if (op_enum == CL.Op.GEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv);
        } else if (op_enum == CL.Op.LEQ) {
            _expression.addVariable(clv, -1.0);
        } else
            // the operator was invalid
            throw new ExCLInternalError(
                    "Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClAbstractVariable clv, CL.Op op_enum,
            ClLinearExpression cle, ClStrength strength)
            throws ExCLInternalError {
        this(clv, op_enum, cle, strength, 1.0);
    }

    public ClLinearInequality(ClAbstractVariable clv, CL.Op op_enum,
            ClLinearExpression cle) throws ExCLInternalError {
        this(clv, op_enum, cle, ClStrength.required, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle, CL.Op op_enum,
            ClAbstractVariable clv, ClStrength strength, double weight)
            throws ExCLInternalError {
        super(((ClLinearExpression) cle.clone()), strength, weight);
        if (op_enum == CL.Op.LEQ) {
            _expression.multiplyMe(-1.0);
            _expression.addVariable(clv);
        } else if (op_enum == CL.Op.GEQ) {
            _expression.addVariable(clv, -1.0);
        } else
            // the operator was invalid
            throw new ExCLInternalError(
                    "Invalid operator in ClLinearInequality constructor");
    }

    public ClLinearInequality(ClLinearExpression cle, CL.Op op_enum,
            ClAbstractVariable clv, ClStrength strength)
            throws ExCLInternalError {
        this(cle, op_enum, clv, strength, 1.0);
    }

    public ClLinearInequality(ClLinearExpression cle, CL.Op op_enum,
            ClAbstractVariable clv) throws ExCLInternalError {
        this(cle, op_enum, clv, ClStrength.required, 1.0);
    }

    public final boolean isInequality() {
        return true;
    }

    public final String toString() {
        return super.toString() + " >= 0 )";
    }
}

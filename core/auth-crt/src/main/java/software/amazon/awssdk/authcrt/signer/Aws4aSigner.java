/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.authcrt.signer;

import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.authcrt.signer.internal.AbstractAws4aSigner;

/**
 * Signer implementation that signs requests with the asymmetric AWS4 (aws4a) signing protocol.
 */
@SdkPublicApi
public final class Aws4aSigner extends AbstractAws4aSigner {

    private Aws4aSigner() {
    }

    /**
     * Creates an instance of an Aws Sigv4a signer
     * @return an instance of an Aws Sigv4a signer
     */
    public static Aws4aSigner create() {
        return new Aws4aSigner();
    }
}
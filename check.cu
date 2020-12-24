#include <stdio.h>
#define ll long long int

const ll m = 0x5DEECE66Dll;
const ll mask = (1ll << 48) - 1;

#define advance1(s) s = (s * m + 11ll) & mask
#define advance2(s)  \
    advance1(s); \
    advance1(s);
#define getIntBounded(x, s, n)              \
    if ((n & (-n)) == n)                    \
    {                                       \
        advance1(s);                        \
        x = (int)((n * (s >> 17)) >> 31);   \
    }                                       \
    else                                    \
    {                                       \
        do                                  \
        {                                   \
            advance1(s);                    \
            bits = s >> 17;                 \
            val = bits % n;                 \
        } while (bits - val + (n - 1) < 0); \
        x = val;                            \
    }
#define nextFloat(x, s) \
    x = ((advance1(s)) >> 32) / 1.6777216E7F;
#define swap(x, y) \
    x += y;        \
    y = x;         \
    x -= y;

__device__
void check_seed(ll seed)
{
    ll color, stem_height;
    ll bits, val;
    float temp;
    ll tempi;
    getIntBounded(color, seed, 5);
    if (color != 0)
    {
        return;
    }
    getIntBounded(stem_height, seed, 5);
    if (stem_height != 0)
    {
        return;
    }
    nextFloat(temp, seed);
    if (temp < 0.25f)
    {
        return;
    }
    nextFloat(temp, seed);
    if (temp < 0.05f)
    {
        return;
    }

    nextFloat(temp, seed);
    if (temp < 0.2f)
    {
        return;
    }

    nextFloat(temp, seed);
    if (temp < 0.2f)
    {
        return;
    }

    nextFloat(temp, seed);
    if (temp < 0.2f)
    {
        return;
    }

    nextFloat(temp, seed);
    if (temp < 0.2f)
        getIntBounded(tempi, seed, 5); // unknown, dynamic skip

    // 2 sides:
    getIntBounded(tempi, seed, 3);
    if (tempi != 0)
    {
        return;
    }

    int a[] = {0, 1, 2, 3};
    /*
    4, 3, 2 as x:
     swap(a[x-1], a[nextInt(x)])
    */
    getIntBounded(tempi, seed, 4);
    swap(a[3], a[tempi]);
    getIntBounded(tempi, seed, 3);
    swap(a[2], a[tempi]);
    getIntBounded(tempi, seed, 2);
    swap(a[1], a[tempi]);
    // 2 = south, 3 = west
    if (a[0] + a[1] != 5)
    {
        return;
    }
    int i;
    for (i = 0; i < 2; i++)
    {
        // height
        getIntBounded(tempi, seed, 5);
        if (tempi != 1)
            return;

        if (a[i] == 2)
        {
            nextFloat(temp, seed);
            if (temp < 0.25f)
                return;
            nextFloat(temp, seed);
            if (temp < 0.05f)
                return;
            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
                getIntBounded(tempi, seed, 5); // unknown, dynamic skip

            advance2(seed); // skip sea pickles and corals which would get overriten

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp >= 0.2f)
            {
                return;
            }

            getIntBounded(tempi, seed, 5);
            if (tempi != 3)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
                getIntBounded(tempi, seed, 5); // unknown, dynamic skip

            // coral on top:
            nextFloat(temp, seed);
            if (temp >= 0.25f)
            {
                return;
            }
            getIntBounded(tempi, seed, 5);
            if (tempi != 4) {
                return;
            }
            

            // wall corals:
            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp >= 0.2f)
            {
                return;
            }
            getIntBounded(tempi, seed, 5);
            if (tempi != 4)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }


            nextFloat(temp, seed);
            if (temp < 0.2f)
                getIntBounded(tempi, seed, 5); // unknown, dynamic skip
        }
        else if (a[i] == 3)
        {
            nextFloat(temp, seed);
            if (temp < 0.25f)
                return;
            nextFloat(temp, seed);
            if (temp < 0.05f)
                return;
            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp >= 0.2f)
            {
                return;
            }

            getIntBounded(tempi, seed, 5);
            if (tempi != 1)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2) getIntBounded(tempi, seed, 5); // unknown, dynamic skip

            advance2(seed); // skip sea pickles and corals which would get overriten

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
                getIntBounded(tempi, seed, 5); // unknown, dynamic skip

            // coral on top:
            nextFloat(temp, seed);
            if (temp >= 0.25f)
            {
                return;
            }
            getIntBounded(tempi, seed, 5);
            if (tempi != 1) {
                return;
            }
            

            // wall corals:
            nextFloat(temp, seed);
            if (temp >= 0.2f)
            {
                return;
            }
            getIntBounded(tempi, seed, 5);
            if (tempi != 0)
            {
                return;
            }


            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }

            nextFloat(temp, seed);
            if (temp < 0.2f)
            {
                return;
            }



            nextFloat(temp, seed);
            if (temp < 0.2f)
                getIntBounded(tempi, seed, 5); // unknown, dynamic skip
        }
    }

    printf("%lld\n", seed);
}

__global__
void find() {
    ll i = 0;
    int index = blockIdx.x * blockDim.x + threadIdx.x;
    int stride = blockDim.x * gridDim.x;
    for (i = index; i < (1ll << 48); i += stride) {
        check_seed(i);
    }
}

int main(void) {
    printf("Begin\n");
    int blockSize = 256;
    ll N = 1ll << 48;
    int numBlocks = (N + blockSize - 1) / blockSize;
    find<<<numBlocks, blockSize>>>();
    cudaDeviceSynchronize();
    printf("End\n");
}
